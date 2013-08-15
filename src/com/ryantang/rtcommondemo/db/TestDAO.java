package com.ryantang.rtcommondemo.db;

import java.util.ArrayList;

import android.content.Context;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.ryantang.common.db.DB4OHelper;
import com.ryantang.common.db.RTBaseDAO;
/**
 * Demo for db4o
 * @Author Ryan
 * @Create 2013-8-15 上午11:00:30
 */
public class TestDAO extends RTBaseDAO {
	
	private ObjectContainer db = null;
	
	public TestDAO(Context context){
		db = DB4OHelper.getObjectContainer(context, "testDB");
	}

	@Override
	public void insert(Object obj) {
//		Student student = (Student)obj;
		//Insert
        Student student1 = new Student("Ryan", 24);
        Student student2 = new Student("TangRen", 23);
        db.store(student1);
        db.store(student2);
        db.commit();//Don't forget commit
	}

	@Override
	public ArrayList<?> query(Object obj) {
		ArrayList<Student> studentsArr = new ArrayList<Student>();
//		Student student = (Student)obj;
		
        Student queryOBJ = new Student();
        //设置查询条件
//      queryOBJ.setAge(23);
        ObjectSet<Student> result = db.queryByExample(queryOBJ);
        while(result.hasNext()){
        	Student st = result.next();
        	studentsArr.add(st);
        	
        	System.out.println("Name:"+st.getName());
        	System.out.println("Age:"+st.getAge());
        }
        
		return studentsArr;
	}

	@Override
	public void update(Object obj, Object newObj) {
		Student updateOBJ = new Student();
        updateOBJ.setName("Ryan");
        ObjectSet<Student> objectSet = db.queryByExample(updateOBJ);
        if (objectSet.hasNext()) {
			Student stu = objectSet.next();
			stu.setAge(25);
			db.store(stu);
			db.commit();
		}
	}

	@Override
	public void delete(Object obj) {
		Student deleteOBJ = new Student();
        deleteOBJ.setAge(23);
        ObjectSet<Student> resultObjectSet = db.queryByExample(deleteOBJ);
        while(resultObjectSet.hasNext()){
        	Student ss = resultObjectSet.next();
        	db.delete(ss);
        }
        db.commit();
	}

	@Override
	public String dropTable() {
		// TODO Auto-generated method stub
		return null;
	}

}

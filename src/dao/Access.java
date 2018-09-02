package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Course;

public class Access
{
	public ArrayList<Course> getCourses(Connection con) throws SQLException
	{
		ArrayList<Course> courseList = new ArrayList<Course>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM courses");
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				Course courseObj = new Course();
				courseObj.setId(rs.getInt("id"));
				courseObj.setCourseCode(rs.getString("coursecode"));
				courseObj.setCourseName(rs.getString("coursename"));
				courseObj.setStudyMode(rs.getString("studymode"));
				courseObj.setAward(rs.getString("award"));
				courseObj.setCredit(rs.getInt("credit"));
				courseObj.setApplicationDeadline(rs.getString("applicationdeadline"));
				courseList.add(courseObj);
			}
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return courseList;		
	}
}

package com.myshow.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.myshow.model.Movie;

/**
 * @author BhargavRajJinka
 *
 */
public interface IRowMapper {
	
	/**
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public List<Movie> mapRow(ResultSet rs) throws SQLException;

}

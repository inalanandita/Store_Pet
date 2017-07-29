package com.nttdata.dbfw;

import java.sql.*;
import java.util.*;
public class DBHelper {

	private DBHelper()
	{
		super();
	}

	public static final org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(DBHelper.class);

	public  static List executeSelect(final Connection con, final String sqlst,
			final ResultMapper outMap) throws DBFWException
	{
		final List resultList = new ArrayList();
		Statement stat = null;
		ResultSet resset = null;
		try
		{
			stat = con.createStatement();
			resset = stat.executeQuery(sqlst);
			while (resset.next())
			{
				final Object obj = outMap.mapRow(resset);
				resultList.add(obj);

			}
		} catch (SQLException e)
		{
			log.debug("Sql Error" + e);
			throw new DBFWException("Execution Failed", e);
		} finally
		{
			try
			{
				if (resset != null)
				{
					resset.close();
				}
				if (stat != null)
				{
					stat.close();
				}
			} catch (SQLException e)
			{
				throw new DBFWException("Finally Failed", e);
			}
		}
		return resultList;
	}

	public static List executeSelect(final Connection con, final String sqlst,
			final ResultMapper outMap, final ParamMapper inmap)
			throws DBFWException
	{
		final List resultList = new ArrayList();
		PreparedStatement prstmt = null;
		ResultSet resset = null;
		try
		{
			prstmt = con.prepareStatement(sqlst);
			inmap.mapParams(prstmt);
			resset = prstmt.executeQuery();
			while (resset.next())
			{
				final Object obj = outMap.mapRow(resset);
				resultList.add(obj);
			}
		} catch (SQLException e)
		{
			log.debug("Sql Error" + e);
			throw new DBFWException("Execution Failed", e);
		} finally
		{
			try
			{
				if (resset != null)
				{
					resset.close();
				}
				if (prstmt != null)
				{
					prstmt.close();
				}
			} catch (SQLException e)
			{
				throw new DBFWException("Finally Failed", e);
			}
		}
		return resultList;
	}

	public static int executeUpdate(final Connection con, final String sqlst,
			final ParamMapper inmap) throws DBFWException
	{
		PreparedStatement prstmt = null;
		try
		{
			prstmt = con.prepareStatement(sqlst);
			inmap.mapParams(prstmt);
			return prstmt.executeUpdate();

		} catch (SQLException e)
		{
			log.debug("Sql Error" + e);
			throw new DBFWException("Execution Failed", e);
		} finally
		{
			try
			{
				if (prstmt != null)
				{
					prstmt.close();
				}
			} catch (SQLException e)
			{
				throw new DBFWException("Finally Failed", e);
			}
		}
	}

	public static Object executeProc(Connection con, String sqlSt,
			ParamMapper inParam, OutTypeMapper outType, OutParamMapper outParam)
			throws SQLException
	{
		Object res = null;
		if ((outType == null && outParam != null)
				|| (outType != null && outParam == null))
		{
			return null;
		}
		CallableStatement callStmt = con.prepareCall(sqlSt);
		inParam.mapParams(callStmt);
		if (outType != null)
		{
			outType.mapOutType(callStmt);
		}
		callStmt.execute();
		if (outParam != null)
		{
			res = outParam.mapOutParam(callStmt);
		}
		return res;
	}

}


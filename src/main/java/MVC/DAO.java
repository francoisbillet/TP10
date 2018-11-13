/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author François
 */
public class DAO {
    protected final DataSource myDataSource;

	/**
	 *
	 * @param dataSource la source de données à utiliser
	 */
	public DAO(DataSource dataSource) {
		this.myDataSource = dataSource;
	}
        
        public int deleteDiscountCode(String code) throws Exception {

		String sql = "DELETE FROM DISCOUNT_CODE AS AUX WHERE DISCOUNT_CODE= ?";
		try (   Connection co = myDataSource.getConnection();
			PreparedStatement stmt = co.prepareStatement(sql)
                ) {
			stmt.setString(1, code);
			return stmt.executeUpdate();

		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new Exception(ex.getMessage());
		}
	}
        
        public int updateDiscountCode(String code,Float taux) throws Exception {

		String sql = "UPDATE APP.DISCOUNT_CODE SET RATE = ? WHERE DISCOUNT_CODE = ?";
		try (   Connection co = myDataSource.getConnection();
			PreparedStatement stmt = co.prepareStatement(sql)
                ) {
			stmt.setFloat(1, taux);
                        stmt.setString(2, code);
			return stmt.executeUpdate();

		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new Exception(ex.getMessage());
		}
	}
        
        public int addDiscountCode(String code, float taux) throws Exception {

		String sql = "INSERT INTO DISCOUNT_CODE VALUES (?,?)";
		try (   Connection connection = myDataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql)
                ) {
			stmt.setString(1, code);
                        stmt.setFloat(2, taux);
			return stmt.executeUpdate();

		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new Exception(ex.getMessage());
		}
	}
        public List<DiscountEntity> DiscountList() throws Exception {
		List<DiscountEntity> result = new LinkedList<>();

		String sql = "SELECT * FROM DISCOUNT_CODE";
		try (Connection co = myDataSource.getConnection();
			PreparedStatement stmt = co.prepareStatement(sql)) {

			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) { 
					String code = rs.getString("DISCOUNT_CODE");
                                        float taux = rs.getFloat("RATE");
                                        DiscountEntity DE = new DiscountEntity(code,taux);
					result.add(DE);
				}
			}
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new Exception(ex.getMessage());
		}

		return result;

	}
        
       
        
}

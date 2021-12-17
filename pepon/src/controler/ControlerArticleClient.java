package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Article;

public class ControlerArticleClient {

	public Article readIdArticle(int idArticle) {
		Article article = null;
		Connection connect = GetConnection.getConnectionWindows();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM article WHERE id_article = ?");
			req.setInt(1, idArticle);
			
			ResultSet rs = req.executeQuery();
			while(rs.next()) {
				//String nomArticle, int nutripoint, double prix, int idCategorie, int idArticle
				article = new Article(rs.getString("nom_article"), rs.getInt("nutripoint"), rs.getDouble("prix"), rs.getInt("id_categorie"), rs.getInt("id_article"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return article;
	}
}

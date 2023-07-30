package edu.poly.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;




@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "Report.FavoriteByYear", procedureName = "spFavoriteByYear", parameters = {
		@StoredProcedureParameter(name = "@Year", type = Integer.class) }, resultClasses = {Report.class  })
})
@Entity
public class Report{
	@Id
	String title;
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	Long likes;
	Date newest;
	Date oldest;

	public Report() {
	}

	
	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	public Date getNewest() {
		return newest;
	}

	public void setNewest(Date newest) {
		this.newest = newest;
	}

	public Date getOldest() {
		return oldest;
	}

	public void setOldest(Date oldest) {
		this.oldest = oldest;
	}

}

package edu.poly.model;

import java.io.Serializable;
import javax.persistence.*;



import java.util.List;

/**
 * The persistent class for the Videos database table.
 * 
 */

@NamedQueries({
	@NamedQuery(name = "Video.findByKeyword", query = "SELECT DISTINCT o.video FROM Favorite o WHERE o.video.title like :keyword"),
	@NamedQuery(name = "Video.findByUser", query = "SELECT f.video FROM Favorite f WHERE f.user.id=:id"),
	@NamedQuery(name = "Video.findInRange", query = "SELECT DISTINCT f.video FROM Favorite f WHERE f.likeDate BETWEEN :min AND :max"),
	@NamedQuery(name = "Video.findByMonth" , query = "SELECT f.video from Favorite f WHERE month(f.likeDate) IN (:months)")
})
@NamedNativeQueries({
	@NamedNativeQuery(name = "Report.random10", query = "SELECT TOP 10 * FROM Videos ORDER BY newid()", resultClass = Video.class)
})
@Entity
@Table(name = "Videos")
@NamedQuery(name = "Video.findAll", query = "SELECT v FROM Video v")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	private String id;

	@Column(name = "Active")
	private boolean active;

	@Column(name = "Description")
	private String description;

	@Column(name = "Poster")
	private String poster;

	@Column(name = "Title")
	private String title;

	@Column(name = "Views")
	private int views;

	// bi-directional many-to-one association to Favorite
	@OneToMany(mappedBy = "video")
	private List<Favorite> favorites;

	public Video() {
	}

	public Video(String id, boolean active, String description, String poster, String title, int views) {
		super();
		this.id = id;
		this.active = active;
		this.description = description;
		this.poster = poster;
		this.title = title;
		this.views = views;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", active=" + active + ", description=" + description + ", poster=" + poster
				+ ", title=" + title + ", views=" + views + "]";
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPoster() {
		return this.poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getViews() {
		return this.views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public List<Favorite> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public Favorite addFavorite(Favorite favorite) {
		getFavorites().add(favorite);
		favorite.setVideo(this);

		return favorite;
	}

	public Favorite removeFavorite(Favorite favorite) {
		getFavorites().remove(favorite);
		favorite.setVideo(null);

		return favorite;
	}

}
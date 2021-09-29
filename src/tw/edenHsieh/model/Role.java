package tw.edenHsieh.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity @Table(name = "role")
public class Role {
	@Id @Column(name = "ROLEID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleid;
	
	@Column(name = "ROLENAME")
	private String rolename;
	
	@Column(name = "SKILL")
	private String skill;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "gamerole",joinColumns = {@JoinColumn(name="roleid")},inverseJoinColumns = {@JoinColumn(name="gameid")})
	private Set<Game> games= new HashSet<Game>();

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}
	
}

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(name = "stock")
public class Stock {
	
	@Id @Column(name = "STOCKID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stockid;
	
	@Column(name = "STOCKNAME")
	private String stockname;
	
	@Column(name = "STOCKCODE")
	private String stockcode;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "stock",cascade = CascadeType.ALL)
	private Set<StockTransaction> stockTrans= new HashSet<StockTransaction>(0);

	
	public Integer getStockid() {
		return stockid;
	}

	public void setStockid(Integer stockid) {
		this.stockid = stockid;
	}

	public String getStockname() {
		return stockname;
	}

	public void setStockname(String stockname) {
		this.stockname = stockname;
	}

	public String getStockcode() {
		return stockcode;
	}

	public void setStockcode(String stockcode) {
		this.stockcode = stockcode;
	}

	public Set<StockTransaction> getStockTrans() {
		return stockTrans;
	}

	public void setStockTrans(Set<StockTransaction> stockTrans) {
		this.stockTrans = stockTrans;
	}

	
}

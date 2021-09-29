package tw.edenHsieh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity @Table(name = "stocktransaction")
public class StockTransaction {

	@Id @Column(name = "STOCKTRANSID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stocktransid;
	
	@Column(name = "TRADEVOLUME")
	private int tradevolume;
	
	//值是參考STOCK(ID)，可直接不寫、不必給值使用Transient忽略
	@Transient @Column(name = "STOCKID") 
	private int stockid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STOCKID")
	private Stock stock;

	public int getStocktransid() {
		return stocktransid;
	}

	public void setStocktransid(int stocktransid) {
		this.stocktransid = stocktransid;
	}

	public int getTradevolume() {
		return tradevolume;
	}

	public void setTradevolume(int tradevolume) {
		this.tradevolume = tradevolume;
	}

	public int getStockid() {
		return stockid;
	}

	public void setStockid(int stockid) {
		this.stockid = stockid;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	
}

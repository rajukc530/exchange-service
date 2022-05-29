package pl.assecods.exchange.modal;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class ExchangeRate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "`table`")
	private String table;

	@Column
	private String no;

	@Column
	private String effectiveDate;

	@Column
	private String currency;

	@Column
	private String code;

	@Column
	private double mid;

}

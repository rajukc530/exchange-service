package pl.assecods.exchange.dto;

import lombok.Data;

@Data
public class Rate {
	public String no;
	public String effectiveDate;
	public double bid;
	public double ask;
}
package pl.assecods.exchange.dto;

import java.util.ArrayList;

import lombok.Data;

@Data
public class CalcuateDto {
    public String table;
    public String currency;
    public String code;
	public ArrayList<Rate> rates;
}

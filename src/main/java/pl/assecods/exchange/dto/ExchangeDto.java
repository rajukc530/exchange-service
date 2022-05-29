package pl.assecods.exchange.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ExchangeDto {
	@JsonProperty("table")
	public String table;
	@JsonProperty("no")
	public String no;
	@JsonProperty("effectiveDate")
	public String effectiveDate;
	@JsonProperty("rates")
	public ArrayList<RateDto> rates;
}
package pl.assecods.exchange.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RateDto {
	@JsonProperty("currency")
	public String currency;
	@JsonProperty("code")
	public String code;
	@JsonProperty("mid")
	public double mid;
}
package pl.assecods.exchange.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Getter
@Setter
public class ExchangeConfig {

	@Value("${exchange-url}" )
	private String exchangeUrl;
	
}

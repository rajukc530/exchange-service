package pl.assecods.exchange.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import pl.assecods.exchange.config.ExchangeConfig;
import pl.assecods.exchange.dto.ExchangeDto;
import pl.assecods.exchange.dto.RateDto;
import pl.assecods.exchange.modal.ExchangeRate;
import pl.assecods.exchange.service.ExchangeRateService;

@Component
public class LoadDBStartupComponent {

	@Autowired
	private ExchangeRateService exchangeRateService;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ExchangeConfig config;

	@EventListener
	public void appReady(ApplicationReadyEvent event) {

		ResponseEntity<ExchangeDto[]> response = restTemplate
				.getForEntity(config.getExchangeUrl() + "/exchangerates/tables/A?format=json", ExchangeDto[].class);

		
		if (response.getStatusCode().is2xxSuccessful()) {
			ExchangeDto tableA = response.getBody()[0];


			List<ExchangeRate> list = new ArrayList<ExchangeRate>();

			for (RateDto rate : tableA.getRates()) {
				ExchangeRate exchangeRate = new ExchangeRate();
				exchangeRate.setTable(tableA.getTable());
				exchangeRate.setNo(tableA.getNo());
				exchangeRate.setEffectiveDate(tableA.getEffectiveDate());
				exchangeRate.setCurrency(rate.getCurrency());
				exchangeRate.setCode(rate.getCode());
				exchangeRate.setMid(rate.getMid());
				list.add(exchangeRate);

			}
			//exchangeRateService.saveAll(list);
		}
	}
}

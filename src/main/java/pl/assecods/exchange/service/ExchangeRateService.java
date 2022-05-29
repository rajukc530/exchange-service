package pl.assecods.exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pl.assecods.exchange.config.ExchangeConfig;
import pl.assecods.exchange.dto.CalcuateDto;
import pl.assecods.exchange.dto.ExchangeDto;
import pl.assecods.exchange.modal.ExchangeRate;
import pl.assecods.exchange.repository.ExchangeRateRepository;

import java.util.List;

@Service
public class ExchangeRateService {

	@Autowired
	private ExchangeRateRepository exchangeRateRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ExchangeConfig config;

	public ExchangeRate save(ExchangeRate entity) {
		ExchangeRate exchangeEntity = exchangeRateRepository.save(entity);
		return exchangeEntity;
	}

	public boolean saveAll(List<ExchangeRate> entities) {
		exchangeRateRepository.saveAll(entities);
		return true;
	}

	public ExchangeRate findExhangeRateByCodeAndEffectiveDate(String code, String effectiveDate) {
		return this.exchangeRateRepository.findExhangeRateByCodeAndEffectiveDate(code, effectiveDate);
	}

	public double calculate(String code, String date) {

		ResponseEntity<CalcuateDto> response = restTemplate.getForEntity(
				config.getExchangeUrl() + "/exchangerates/tables/C/" + code + "?format=json", CalcuateDto.class);

		if (response.getStatusCode().is2xxSuccessful()) {
			CalcuateDto dto = response.getBody();

			double price = dto.getRates().get(0).getAsk();

			// fetch from table A save in db and do some conversion.
			// Logic not implmented
			double result = price * 1;
			return result;
		}
		return 0.0;
	}
}

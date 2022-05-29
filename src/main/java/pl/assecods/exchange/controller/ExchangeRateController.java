package pl.assecods.exchange.controller;

import lombok.extern.log4j.Log4j;
import pl.assecods.exchange.modal.ExchangeRate;
import pl.assecods.exchange.service.ExchangeRateService;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/exchange-rate")
@Log4j
public class ExchangeRateController {

	public static final Logger log = LoggerFactory.getLogger(ExchangeRateController.class.getName());

	@Autowired
	private ExchangeRateService exchangeRateService;

	@GetMapping
	public ExchangeRate findExchangeRateByCodeAndDate(@RequestParam String currencyCode,
			@RequestParam String effectiveDate) {
		log.info("Get Exchange rate for " + currencyCode + " & Date " + effectiveDate);
		if (StringUtils.isEmpty(currencyCode))
			throw new RuntimeException("CurrencyCode Cannot be Empty");

		if (StringUtils.isEmpty(effectiveDate))
			throw new RuntimeException("EffectiveDate Cannot be Empty");

		return exchangeRateService.findExhangeRateByCodeAndEffectiveDate(currencyCode, effectiveDate);
	}

	@GetMapping("/calculate")
	public double calcuate(@RequestParam String currencyCode, @RequestParam String effectiveDate) {

		return exchangeRateService.calculate(currencyCode, effectiveDate);
	}

}

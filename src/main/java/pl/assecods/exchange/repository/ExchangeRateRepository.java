package pl.assecods.exchange.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.assecods.exchange.modal.ExchangeRate;

@Repository
public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, Long> {
	ExchangeRate findExhangeRateByCodeAndEffectiveDate(String code, String effectiveDate);
}

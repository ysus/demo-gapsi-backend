package com.gapsi.repository;

import com.gapsi.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProviderRepository extends PagingAndSortingRepository<Provider, Long> {
    Provider findProviderByName(String providerName);
}


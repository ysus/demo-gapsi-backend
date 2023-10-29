package com.gapsi.service.impl;

import com.gapsi.exception.ProviderExistException;
import com.gapsi.model.Provider;
import com.gapsi.repository.ProviderRepository;
import com.gapsi.service.ProviderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl implements ProviderService {

    private static final String PROVIDER_ALREADY_EXISTS = "El Proveedor ya existe";
    private final ProviderRepository providerRepository;

    public ProviderServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public Page<Provider> getProviders(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        return providerRepository.findAll(paging);
    }

    @Override
    public Provider saveProvider(Provider provider) throws ProviderExistException {
        validateNewProvider(provider.getName());
        return providerRepository.save(provider);
    }

    @Override
    public void deleteProvider(long id) {
        providerRepository.deleteById(id);
    }

    private void validateNewProvider(String providerName) throws ProviderExistException {
        Provider provider = providerRepository.findProviderByName(providerName);
        if(provider != null){
            throw new ProviderExistException(PROVIDER_ALREADY_EXISTS);
        }
    }
}

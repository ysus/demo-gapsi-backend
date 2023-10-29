package com.gapsi.service;

import com.gapsi.exception.ProviderExistException;
import com.gapsi.model.Provider;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

public interface ProviderService {

    Page<Provider> getProviders(int page, int size);
    Provider saveProvider(Provider provider) throws ProviderExistException;
    void deleteProvider(long id);

}

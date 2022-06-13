package com.example.market.service.azamat;

import com.example.market.dto.azamat.MerchantsDto;
import com.example.market.exception.MarketException;
import com.example.market.model.azamat.Merchants;
import com.example.market.repository.azamat.MerchantsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MerchantsService {
    private MerchantsRepository merchantsRepository;
    public boolean create(MerchantsDto merchantsDto) {
        Merchants merchants = new Merchants();
        merchantsDto.setId(merchants.getId());
        convertDtoToEntity(merchantsDto, merchants);
        merchantsRepository.save(merchants);
        return true;
    }

    public MerchantsDto get(Integer id) {
        Merchants merchants = getEntity(id);
        MerchantsDto merchantsDto = new MerchantsDto();
        convertEntityToDto(merchantsDto, merchants);
        return merchantsDto;
    }

    public boolean update(Integer id, MerchantsDto merchantsDto) {
        Merchants update = getEntity(id);
        update.setName(merchantsDto.getName());
        update.setStatus(true);
        update.setIsFeatured(true);
        update.setUpdatedAt(LocalDateTime.now());
        merchantsRepository.save(update);
        return true;
    }

    public boolean delete(Integer id) {
        Merchants merchants = getEntity(id);
        merchants.setDeletedAt(LocalDateTime.now());
        merchantsRepository.save(merchants);
        return true;
    }

    Merchants getEntity(Integer id) {
        Optional<Merchants> optional = merchantsRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new MarketException("Merchants not found");
        }
        return optional.get();
    }

    private void convertDtoToEntity(MerchantsDto dto, Merchants entity) {
        entity.setName(dto.getName());
        entity.setSlug(dto.getSlug());
        entity.setImageThumb(dto.getImageThumb());
        entity.setPhone(dto.getPhone());
        entity.setMobile(dto.getMobile());
        entity.setEmail(dto.getEmail());
        entity.setWebsite(dto.getWebsite());
        entity.setAddress(dto.getAddress());
        entity.setCountry(dto.getCountry());
        entity.setIsFeatured(true);
        entity.setStatus(true);
        entity.setCreatedAt(LocalDateTime.now());
    }

    private void convertEntityToDto(MerchantsDto dto, Merchants entity) {
        dto.setSlug(entity.getSlug());
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setImageThumb(entity.getImageThumb());
        dto.setPhone(entity.getPhone());
        dto.setMobile(entity.getMobile());
        dto.setEmail(entity.getEmail());
        dto.setWebsite(entity.getWebsite());
        dto.setAddress(entity.getAddress());
        dto.setCountry(entity.getCountry());
    }

}

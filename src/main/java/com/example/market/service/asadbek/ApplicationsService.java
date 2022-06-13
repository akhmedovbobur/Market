package com.example.market.service.asadbek;

import com.example.market.dto.asadbek.ApplicationsDto;
import com.example.market.model.asadbek.Applications;
import com.example.market.repository.asadbek.ApplicationsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ApplicationsService {
    private ApplicationsRepository applicationsRepository;

    public Boolean create(ApplicationsDto applicationsDto) {
        Applications applications = new Applications();
        convertToDtoEntity(applicationsDto,applications);
        applications.setCreateAt(LocalDateTime.now());
        applicationsRepository.save(applications);
        return true;
    }


    public ApplicationsDto get(Integer id) {
        Applications applications = getEntity(id);
        ApplicationsDto applicationsDto = new ApplicationsDto();
        convertToDtoEntity(applicationsDto,applications);
        return applicationsDto;
    }

    public Boolean update(Integer id, ApplicationsDto applicationsDto) {
        Applications old = getEntity(id);
        convertToDtoEntity(applicationsDto,old);
        old.setUpdateAt(LocalDateTime.now());
        applicationsRepository.save(old);
        return true;
    }

    public Boolean delete(Integer id) {
        Applications applications = getEntity(id);
        applications.setDeleteAt(LocalDateTime.now());
        applicationsRepository.save(applications);
        return true;
    }

    public Applications getEntity(Integer id){
        Optional<Applications> optional = applicationsRepository.findById(id);
        if (optional.isEmpty()){
            throw new IllegalArgumentException("User not found");
        }
        return optional.get();
    }

    public void convertToDtoEntity(ApplicationsDto applicationsDto,Applications applications){
        applications.setConditionPrice(applicationsDto.getConditionPrice());
        applications.setConditionDurationType(applications.getConditionDurationType());
        applications.setMerchantId(applicationsDto.getMerchantId());
        applications.setProsesStatusId(applicationsDto.getProsesStatusId());
        applications.setPrice(applicationsDto.getPrice());
        applications.setUserId(applicationsDto.getUserId());
        applications.setVehicleDetails(applicationsDto.getVehicleDetails());
        applications.setVehicleId(applicationsDto.getVehicleId());
        applications.setConditionDuration(applicationsDto.getConditionDuration());
        applications.setTypeId(applicationsDto.getTypeId());
    }

}

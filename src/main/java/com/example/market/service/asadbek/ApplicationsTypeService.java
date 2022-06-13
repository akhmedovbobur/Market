package com.example.market.service.asadbek;

import com.example.market.dto.asadbek.ApplicationsTypeDto;
import com.example.market.model.asadbek.ApplicationsType;
import com.example.market.repository.asadbek.ApplicationsTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ApplicationsTypeService {
    private ApplicationsTypeRepository applicationsTypeRepository;

    public Boolean create(ApplicationsTypeDto applicationsTypeDto) {
       ApplicationsType applicationsType = new ApplicationsType();
       convertToDtoEntity(applicationsTypeDto,applicationsType);
       applicationsType.setCreateAt(LocalDateTime.now());
       applicationsTypeRepository.save(applicationsType);
       return true;
    }

    public ApplicationsTypeDto get(Integer id) {
        ApplicationsType applicationsType = getEntity(id);
        ApplicationsTypeDto applicationsTypeDto = new ApplicationsTypeDto();
        convertToDtoEntity(applicationsTypeDto,applicationsType);
        return applicationsTypeDto;
    }

    public Boolean update(Integer id, ApplicationsTypeDto applicationsTypeDto) {
          ApplicationsType old = getEntity(id);
          convertToDtoEntity(applicationsTypeDto,old);
          old.setUpdateAt(LocalDateTime.now());
          applicationsTypeRepository.save(old);
          return true;
    }

    public Boolean delete(Integer id) {
        ApplicationsType applicationsType = getEntity(id);
        applicationsType.setDeleteAt(LocalDateTime.now());
        applicationsTypeRepository.save(applicationsType);
        return true;
    }

    public ApplicationsType getEntity(Integer id){
        Optional<ApplicationsType> optional = applicationsTypeRepository.findById(id);
        if (optional.isEmpty()){
            throw new IllegalArgumentException("User not found");
        }
        return optional.get();
    }

    public void convertToDtoEntity(ApplicationsTypeDto applicationsTypeDto,ApplicationsType applicationsType){
        applicationsType.setDisplayClass(applicationsTypeDto.getDisplayClass());
        applicationsType.setDisplayName(applicationsTypeDto.getDisplayName());
        applicationsType.setDisplayIcon(applicationsTypeDto.getDisplayIcon());
    }
}

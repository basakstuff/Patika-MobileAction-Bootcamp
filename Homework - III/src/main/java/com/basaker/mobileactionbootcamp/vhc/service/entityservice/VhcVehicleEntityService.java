package com.basaker.mobileactionbootcamp.vhc.service.entityservice;

import com.basaker.mobileactionbootcamp.gen.exceptions.DuplicateException;
import com.basaker.mobileactionbootcamp.gen.service.BaseEntityService;
import com.basaker.mobileactionbootcamp.vhc.Exceptions.VhcVehicleErrorMessage;
import com.basaker.mobileactionbootcamp.vhc.dao.VhcVehicleDao;
import com.basaker.mobileactionbootcamp.vhc.entity.VhcVehicle;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Basak Er
 * @since 1.0.0
 */
@Service
public class VhcVehicleEntityService extends BaseEntityService<VhcVehicle, VhcVehicleDao> {

    public VhcVehicleEntityService(VhcVehicleDao dao) {
        super(dao);
    }


    public VhcVehicle saveWithControlPlate(VhcVehicle vhcVehicle) {

        //plaka dogrulamasi
        Matcher m = Pattern.compile("[A-Z0-9. ]*").matcher(vhcVehicle.getPlate());
        if (!m.find()) {
            throw new DuplicateException(VhcVehicleErrorMessage.VEHICLE_INVALID_PLATE);
        }
        //ayni plaka kullanilmis mi diye kontrol eder
        boolean isUniquePlate = !getDao().existsByPlate(vhcVehicle.getPlate());

        if (!isUniquePlate) {
            throw new DuplicateException(VhcVehicleErrorMessage.VEHICLE_ALREADY_EXIST);
        }

        vhcVehicle = save(vhcVehicle);

        return vhcVehicle;
    }

}

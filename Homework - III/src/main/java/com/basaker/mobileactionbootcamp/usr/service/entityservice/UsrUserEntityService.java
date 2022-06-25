package com.basaker.mobileactionbootcamp.usr.service.entityservice;

import com.basaker.mobileactionbootcamp.gen.exceptions.DuplicateException;
import com.basaker.mobileactionbootcamp.gen.service.BaseEntityService;
import com.basaker.mobileactionbootcamp.usr.dao.UsrUserDao;
import com.basaker.mobileactionbootcamp.usr.entity.UsrUser;
import com.basaker.mobileactionbootcamp.usr.exceptions.UsrUserErrorMessage;
import org.springframework.stereotype.Service;

/**
 * @author Basak Er
 * @since 1.0.0
 */
@Service
public class UsrUserEntityService extends BaseEntityService<UsrUser, UsrUserDao> {

    public UsrUserEntityService(UsrUserDao dao) {
        super(dao);
    }

    public UsrUser findByUsername(String username) {
        return getDao().findByUsername(username);
    }

    public UsrUser saveWithControlUsername(UsrUser usrUser) {
        //ayni kullanici adi kullanilmis diye kontrol eder
        boolean isUniqueUsername = !getDao().existsByUsername(usrUser.getUsername());

        if (!isUniqueUsername) {
            throw new DuplicateException(UsrUserErrorMessage.USERNAME_ALREADY_EXIST);
        }

        usrUser = save(usrUser);

        return usrUser;
    }
}

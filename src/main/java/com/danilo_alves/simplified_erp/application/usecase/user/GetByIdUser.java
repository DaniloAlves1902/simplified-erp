package com.danilo_alves.simplified_erp.application.usecase.user;

import com.danilo_alves.simplified_erp.application.usecase.UseCase;
import com.danilo_alves.simplified_erp.domain.entity.user.UserDomain;

public interface GetByIdUser extends UseCase<String, UserDomain> {
}

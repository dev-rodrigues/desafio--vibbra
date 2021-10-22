package com.vibbra.user.datasources.h2.data;

import com.vibbra.user.datasources.h2.model.InviteModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InviteData extends CrudRepository<InviteModel, Long> {

    List<InviteModel> findByUser(Long id);

}

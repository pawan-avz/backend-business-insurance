package com.backend.BIPC.services.auth;

import com.backend.BIPC.Exception.GenericException;
import com.backend.BIPC.entities.auth.User;
import com.backend.BIPC.form.ChangePasswordForm;

public interface UserService {
  public String changePassword(ChangePasswordForm changePasswordForm) throws Exception;

  public   User saveUser(User user);
}

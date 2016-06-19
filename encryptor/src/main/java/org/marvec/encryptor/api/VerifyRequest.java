/*
 * -----------------------------------------------------------------------\
 * SilverWare
 *  
 * Copyright (C) 2014 - 2016 the original author or authors.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * -----------------------------------------------------------------------/
 */
package org.marvec.encryptor.api;

import org.marvec.encryptor.util.EncryptionException;
import org.marvec.encryptor.util.EncryptionUtil;

/**
 * @author <a href="mailto:marvenec@gmail.com">Martin Večeřa</a>
 */
public class VerifyRequest extends KeyRequest<Boolean> {

   private String message;

   private String signature;

   public String getMessage() {
      return message;
   }

   public void setMessage(final String message) {
      this.message = message;
   }

   public String getSignature() {
      return signature;
   }

   public void setSignature(final String signature) {
      this.signature = signature;
   }

   @Override
   public Boolean doProcess() throws EncryptionException {
      checkAttribute(message);
      checkAttribute(signature);

      return encryptionUtil.verify(message, signature);
   }
}

# Overview

During my experiences working with Java, there are must be cases that I have to use properties files in order to store configurable parameter. For example, folder location for storing temporary files or wsdl location if I need to invoke SOAP services. But sometimes, I need to store sensitive information, such as database password in the configuration file. Therefore, we need to encrypt property value for sensitive information, in order to make it harder for the attacker to compromise our system.

# Use Case
For the use case, I want to encrypt property value with key ``variable.secret-var` in the property file. The encrypted value then will be decrypted during the runtime.

# STEP: GENERATE ENCRYPTED TEXT
```
C:\Users\user\.m2\repository\org\jasypt\jasypt\1.9.2>java -cp jasypt-1.9.2.jar org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="RageAgainstTheMachine" password=secretkey

----ENVIRONMENT-----------------
Runtime: Oracle Corporation Java HotSpot(TM) 64-Bit Server VM 25.171-b11

----ARGUMENTS-------------------
input: RageAgainstTheMachine
password: secretkey

----OUTPUT----------------------
kseAM0ODxH0xbjohM0rGIaodUjXdEOp0zUI0t3QuBXQ=
```

Note: you may get a different output since jasypt use salt mechanism

#STEP: SET ENCRYPTED VALUE

Then put the encrypted value into variable.secret-var key in application.yml file.

```
variable:
  secret-var: ENC(kseAM0ODxH0xbjohM0rGIaodUjXdEOp0zUI0t3QuBXQ=)
```

# Conclusion
So, that is it. Now you can encrypt the variable value inside property file. However, maybe you are wondering, it would be non-sense if we put the encrypted variable and the jasypt configuration into one property file. For this cases, we can make separate property file between jasypt configuration and the encrypted value. The technique is using externalized configuration. But that would be out of scope for this post. I will try to bring it in the future.

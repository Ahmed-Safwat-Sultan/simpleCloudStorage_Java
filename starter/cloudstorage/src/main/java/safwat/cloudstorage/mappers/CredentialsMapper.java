package safwat.cloudstorage.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import safwat.cloudstorage.model.Credentials;
import safwat.cloudstorage.model.User;

@Mapper
public interface CredentialsMapper {
	
	@Select("SELECT * FROM CREDENTIALS WHERE credentialid = #{credentialId}")
	Credentials findCredentialsById(int credentialId);
	
	@Select("SELECT * FROM CREDENTIALS WHERE userid = #{userId}")
	List<Credentials> findAllCredentials(User user);
	
	
	@Insert("INSERT INTO CREDENTIALS (url, username, key, password, userid) "
			+ "VALUES(#{url}, #{userName},#{key}, #{password}, #{userId})")
	@Options(useGeneratedKeys = true, keyProperty = "credentialId")
	int insertCredentials(Credentials credentials);
	
	@Update("UPDATE CREDENTIALS SET url = #{url}, username = #{userName},"
			+ "password = #{password} WHERE credentialid = #{credentialId}")
	int updateCredentials(Credentials credentials);
	
	
	@Delete("DELETE FROM CREDENTIALS WHERE credentialid = #{credentialId}")
	void deleteCredential(int credentialId);
	
}

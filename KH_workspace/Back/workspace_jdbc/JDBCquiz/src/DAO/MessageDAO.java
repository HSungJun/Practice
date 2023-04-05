package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import DTO.MessageDTO;

public class MessageDAO {

	BasicDataSource bds = new BasicDataSource();
	
									
	public MessageDAO() {
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("board");
		bds.setPassword("board");
		bds.setInitialSize(6);
	}
	
	private Connection getConnection () throws Exception {
		return bds.getConnection();
	}
	
	public int insert(String writer, String message) throws Exception{
		String sql = "insert into messages values(message_seq.nextval,?,?,sysdate)";
		try(Connection con  = this.getConnection();	
				PreparedStatement pstat = con.prepareStatement(sql)){
		pstat.setString(1, writer);
		pstat.setString(2, message);
		int result = pstat.executeUpdate();
		con.commit();
		return result;
		}
	}
	
	public List<MessageDTO> messageList () throws Exception{
		String sql = "select * from messages";
		try(Connection con  = this.getConnection();	
			PreparedStatement pstat = con.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();){
			List<MessageDTO> result = new ArrayList<>();
			while (rs.next()) {
				int seq = rs.getInt("seq");
				String writer = rs.getString("writer");
				String message = rs.getString("message");
				Timestamp write_date = rs.getTimestamp("write_date");
				
				MessageDTO dto = new MessageDTO(seq,writer,message,write_date);
				result.add(dto);
			}
			return result;
		}
	}
	
	public List<MessageDTO> search(String st)throws Exception{
		String sql = "select * from messages where writer like '%"+st+"%' or message like'%"+st+"%' ";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			ResultSet rs = pstat.executeQuery();
			List<MessageDTO> result = new ArrayList<>();
			while (rs.next()) {
				int seq = rs.getInt("seq");
				String writer = rs.getString("writer");
				String message = rs.getString("message");
				Timestamp write_date = rs.getTimestamp("write_date");
				
				MessageDTO dto = new MessageDTO(seq,writer,message,write_date);
				result.add(dto);
			}
			return result;
			
		}
		
	}
	
	
	public int delete (int seq) throws Exception{
		String sql = "delete from messages where seq = ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, seq);
			int result = pstat.executeUpdate();
			con.commit();
			return result;
		}
	}
	
	
	public int update (MessageDTO dto) throws Exception{
		String sql = "update messages set writer = ? , message = ? where seq = ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getMessage());
			pstat.setInt(3, dto.getSeq());
			int result = pstat.executeUpdate();
			con.commit();
			return result;
		}
	}
	
	public boolean seqExist(int seq) throws Exception {
		String sql = "select * from messages where seq = ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, seq);
			try(ResultSet rs = pstat.executeQuery();){
				boolean result = rs.next();
				return result;
			}
		}
	}
	
	
	
	
	
	
}

package com.mongotest2.seq.dao;

public interface SequenceDao {
	public long getNextSequenceId(String key);
}

package Model;

import java.io.Serializable;

public class User implements Serializable {
	private long Id;
private String name;
private int score;
private int random;
public void User (String name,int score,int random)
{
this.name=name;
this.score=score;
this.random=random;

}

public int getRandom() {
	return random;
}

public void setRandom(int random) {
	this.random = random;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getScore() {
	return score;
}

public long getId() {
	return Id;
}

public void setId(long id) {
	Id = id;
}

public void setScore(int score) {
	this.score = score;
}



}

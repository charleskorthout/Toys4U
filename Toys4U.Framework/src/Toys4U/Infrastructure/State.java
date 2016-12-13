package Toys4U.Infrastructure;

public interface State {

	void update();

	void exit();

	void render();

	void enter();

}
package Toys4U.Infrastructure;

public interface Revertable {

	void current();

	void undo();

	void redo();

}
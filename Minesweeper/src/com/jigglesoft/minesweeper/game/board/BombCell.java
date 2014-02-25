package com.jigglesoft.minesweeper.game.board;

public class BombCell extends Cell {
	
	
	@Override
	public boolean isBomb() {
		return true;
	}

}

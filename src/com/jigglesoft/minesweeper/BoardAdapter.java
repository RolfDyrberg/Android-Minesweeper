package com.jigglesoft.minesweeper;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.jigglesoft.minesweeper.game.board.Board;
import com.jigglesoft.minesweeper.game.board.Cell;

public class BoardAdapter extends BaseAdapter {
	
	private Context context;
	
	private Cell[] cellArray;
	
	
	public BoardAdapter(Context c, Board board) {
		
		context = c;
		
		ArrayList<Cell> cells = new ArrayList<Cell>();
		
		for (Cell[] row : board.getCells()){
			for (Cell cell : row){
				cells.add(cell);
			}
		}
		
		this.cellArray = new Cell[cells.size()];
		cells.toArray(this.cellArray);
		
	}

	@Override
	public int getCount() {
		return cellArray.length;
	}

	@Override
	public Object getItem(int position) {
		return cellArray[position];
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView = new SquareImageView(context);
		
		
		int resId = getImageResourceForCell(cellArray[position]);
		imageView.setImageResource(resId);
		

		return imageView;
	}
	
	private int getImageResourceForCell(Cell cell) {
		
		if (cell.isRevealed()){
			
			if (cell.isBomb()) return R.drawable.bomb_cell;
			if (cell.hasBombNeighbor()) {
				
				switch (cell.noOfNeighborIsBomb()) {
				case 1:
					return R.drawable.neighbor_1;
				case 2:
					return R.drawable.neighbor_2;
				case 3:
					return R.drawable.neighbor_3;
				case 4:
					return R.drawable.neighbor_4;
				case 5:
					return R.drawable.neighbor_5;
				case 6:
					return R.drawable.neighbor_6;
				case 7:
					return R.drawable.neighbor_7;
				case 8:
					return R.drawable.neighbor_8;
				default:
					return R.drawable.revealed_cell;
				}
				
			}
			return R.drawable.revealed_cell;
		}
		if (cell.hasWarningFlag()) return R.drawable.warning_flag;
		
		return R.drawable.hidden_cell;
	}

	
}

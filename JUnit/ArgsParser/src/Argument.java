/* dcParseArgs - Java library to simplify args[] handling
 * 
 * Copyright (C) 2008 Roland Koller <roland@devcity.de>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public 
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */


public class Argument implements Comparable<Argument> {

	int position;

	public Argument(int position) {
		this.position = position;
	}

	public int getPosition() {
		return position;
	}

	public int compareTo(Argument arg0) {
		return position - arg0.getPosition();
	}

}
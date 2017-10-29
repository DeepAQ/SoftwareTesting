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


public abstract class KeyArgument extends Argument {

	String key;
	
	public KeyArgument(int position, String key) {
		super(position);
		if(key == null) throw new NullPointerException();
		if(key.length() == 0) throw new IllegalArgumentException("Key cannot be an empty string.");
		this.key = key;
	}
	
	public boolean isLongKey() {
		return (key.length() > 1);
	}
	
	public String getKey() {
		return key;
	}

}

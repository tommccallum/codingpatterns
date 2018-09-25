/* 
 * Copyright (C) 2018 Tom McCallum
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package adapterpattern;

/**
 *
 * @author Tom McCallum
 */
public class AdapterPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // the adapter allows us to use our existing interfaces
        // wrapping a vendor item.
        // Vendor can change their code and the rest of our system is protected.
        VendorSpecific v = new VendorSpecific();
        ProprietaryItem adapter = new VendorToProprietaryAdapter(v);
        
        adapter.add();
        adapter.remove();
    }
    
}

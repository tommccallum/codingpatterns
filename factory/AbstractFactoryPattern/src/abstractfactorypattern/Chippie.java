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
package abstractfactorypattern;

/**
 *
 * @author Tom McCallum
 */
public abstract class Chippie {
    
    // we keep the common functionality in the top class
    public final FishnChips orderSupper() {
        FishnChips supper = createFishnChips();
        supper.prepare();
        supper.fry();
        supper.wrap();
        return supper;
    }
    
    // this lets the subclass decide what type of fish n chips to serve
    // it saves us having lots of IF...THEN statements
    protected abstract FishnChips createFishnChips();
}

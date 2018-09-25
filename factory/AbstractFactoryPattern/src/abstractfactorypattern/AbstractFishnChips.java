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
public class AbstractFishnChips implements FishnChips {
    private String fish;
    
    @Override
    public void prepare() {
        System.out.println("prepare "+fish);
    }
    
    @Override
    public void fry() {
        System.out.println("fry "+fish+ " and chips");
    }
    
    @Override
    public void wrap() {
        System.out.println("wrap "+fish+ " n chips");
    }

    public final String getFish() {
        return fish;
    }

    public final void setFish(String fish) {
        this.fish = fish;
    }
}

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
package strategypattern;

/**
 * Duck EXTENDS the concept of BIRD via INHERITANCE
 * @author Tom McCallum
 */
public class Duck extends Bird {
    public Duck() {
        this.setFlyBehaviour(new Fly());
        this.setVoiceBehaviour( new Quack());
        this.setDescription("Duck");
    }
}
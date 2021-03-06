/* Copyright (c) 2014 Jesper Öqvist <jesper@llbit.se>
 *
 * This file is part of Chunky.
 *
 * Chunky is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Chunky is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with Chunky.  If not, see <http://www.gnu.org/licenses/>.
 */
package se.llbit.chunky.map;

import se.llbit.chunky.world.Icon;
import se.llbit.util.ImageTools;

/**
 * Represents a chunk with corrupt chunk data.
 *
 * @author Jesper Öqvist <jesper@llbit.se>
 */
public class CorruptLayer extends AbstractLayer {

  /**
   * Singleton instance.
   */
  public static final CorruptLayer INSTANCE = new CorruptLayer();

  private CorruptLayer() {
  }

  @Override public synchronized void render(MapTile tile) {
    if (tile.scale == 1) {
      tile.setPixel(0, 0, averageColor);
    } else {
      // TODO: scale the image to the current tile size.
      tile.drawImage(Icon.corruptLayer.getBitmap());
    }
  }

  private final int averageColor = Icon.corruptLayer.getAvgColor();

  @Override public int getAvgColor() {
    return averageColor;
  }

}

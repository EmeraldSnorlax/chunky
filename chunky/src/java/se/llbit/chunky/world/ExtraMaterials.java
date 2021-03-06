/* Copyright (c) 2019 Jesper Öqvist <jesper@llbit.se>
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
package se.llbit.chunky.world;

import se.llbit.chunky.world.material.CloudMaterial;

import java.util.HashMap;
import java.util.Map;

public class ExtraMaterials {
  public static final Map<String, Material> idMap = new HashMap<>();
  static {
    idMap.put("cloud", CloudMaterial.INSTANCE);
  }

  public static void loadDefaultMaterialProperties() {
    for (Material material : idMap.values()) {
      material.opaque = false;
      material.solid = true;
      material.localIntersect = false;
      material.invisible = false;
      material.emittance = 0;
      material.specular = 0;
      material.ior = 1.000293f;
    }
  }
}

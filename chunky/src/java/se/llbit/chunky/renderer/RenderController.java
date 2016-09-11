/* Copyright (c) 2016 Jesper Öqvist <jesper@llbit.se>
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
package se.llbit.chunky.renderer;

import se.llbit.chunky.main.ChunkyOptions;
import se.llbit.chunky.renderer.scene.AsynchronousSceneManager;

/**
 * Contains all state for the renderer.
 */
public class RenderController {
  private final AsynchronousSceneManager sceneManager;
  private final Renderer renderer;
  private final RenderContext context;

  public RenderController(ChunkyOptions options) {
    context = new RenderContext(options);
    renderer = new RenderManager(context);
    sceneManager = new AsynchronousSceneManager(context, renderer);
    renderer.setSceneProvider(sceneManager.getSceneProvider());
    renderer.start();
    sceneManager.start();
  }

  public AsynchronousSceneManager getSceneManager() {
    return sceneManager;
  }

  public Renderer getRenderer() {
    return renderer;
  }

  public RenderContext getContext() {
    return context;
  }

  public SceneProvider getSceneProvider() {
    return sceneManager.getSceneProvider();
  }
}
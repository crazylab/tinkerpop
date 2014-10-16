package com.tinkerpop.gremlin.process.graph.strategy;

import com.tinkerpop.gremlin.process.Traversal;
import com.tinkerpop.gremlin.process.TraversalStrategy;
import com.tinkerpop.gremlin.process.graph.step.util.MarkerIdentityStep;
import com.tinkerpop.gremlin.process.util.TraversalHelper;
import com.tinkerpop.gremlin.structure.util.StringFactory;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LabeledEndStepStrategy implements TraversalStrategy.NoDependencies {

    private static final LabeledEndStepStrategy INSTANCE = new LabeledEndStepStrategy();

    private LabeledEndStepStrategy() {
    }

    @Override
    public void apply(final Traversal<?, ?> traversal) {
        if (TraversalHelper.isLabeled(TraversalHelper.getEnd(traversal)))
            traversal.addStep(new MarkerIdentityStep<>(traversal));
    }

    public static LabeledEndStepStrategy instance() {
        return INSTANCE;
    }

    @Override
    public String toString() {
        return StringFactory.traversalStrategyString(this);
    }
}
